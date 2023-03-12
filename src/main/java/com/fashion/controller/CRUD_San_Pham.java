package com.fashion.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fashion.entity.Hinhanh;
import com.fashion.entity.LoaiSanPham;
import com.fashion.entity.NhanHieu;
import com.fashion.entity.Sanpham;
import com.fashion.entity.ThongBao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
public class CRUD_San_Pham {

	// Lấy ra cái list sản phẩm
	private static void listSanPham(Model model) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/list-san-pham";
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<Sanpham>>() {
		}.getType();
		List<Sanpham> listok = gs.fromJson(data, typeOfT);
		model.addAttribute("list", listok);
	}

	// Lấy cái list nhãn hiệu và list loại sản phẩm
	private static void ListNhanHieu(Model model) {
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/Nhan-hieu/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeOfT = new TypeToken<List<NhanHieu>>() {
		}.getType();
		List<NhanHieu> list = gs.fromJson(data, typeOfT);
		model.addAttribute("list", list);
	}

	// Lấy ra loại sản phẩm
	private static void ListLoaiSanPham(Model model) {
		// Lấy ra loai sản phẩm
		Gson gs = new Gson();
		String URL2 = "http://localhost:8080/Fashion-Shop-Api/rest/The-loai/list";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL2);
		String listTl = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Type typeTl = new TypeToken<List<LoaiSanPham>>() {
		}.getType();
		List<LoaiSanPham> loaisp = gs.fromJson(listTl, typeTl);
		model.addAttribute("lsp", loaisp);
	}

	@GetMapping(value = "/delete-san-pham/{idxoa}")
	public String deleteSanPham(@PathVariable(value = "idxoa") int xoaok, HttpServletRequest request, Model model) {
		// Delete cả hình ảnh ở trong lưu trữ file
		Sanpham sp = TienIch.searchIdSanPham(xoaok);
		List<Hinhanh> listhinhanh = TienIch.selectByIdSpHinhAnh(sp.getId());
		for (Hinhanh xoaha : listhinhanh) {
			String tenanh = xoaha.getName();
			String ddgoc = request.getServletContext().getRealPath("/public/img");
			File file = new File(ddgoc + File.separator + tenanh);
			Boolean xoaTc = file.delete();
			if (xoaTc) {
				System.out.println("Đã xóa file img thành công");
			} else {
				System.out.println("Xóa ko thành công");
			}
		}
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/delete/" + xoaok;
		// Xóa
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Sanpham sanpham = new Sanpham();
		Gson gs = new Gson();
		String xoaOk = gs.toJson(sanpham);
		Response response = target.request().post(Entity.entity(xoaOk, MediaType.APPLICATION_JSON));
		String trave = response.readEntity(String.class);
		ThongBao tb = gs.fromJson(trave, ThongBao.class);
		model.addAttribute("tb", tb);
		// Nạp lại cái list
		int sotrang = 1;
		sotrang = Integer.parseInt(request.getParameter("page"));
		List<Sanpham> list = TienIch.PhanTrang(sotrang);
		model.addAttribute("list", list);
		model.addAttribute("sotrang", sotrang);
		// Nạp lại số trang
		Long slsp = TienIch.count();
		model.addAttribute("sl", slsp);
		return "admin/sanpham";
	}

	/// Update sản phẩm
	@GetMapping(value = "/update-san-pham/{idla}")
	public String updateSanPham(@PathVariable(value = "idla") int idla, Model model) {
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/search-id/" + idla;
		// Lấy ra sản phẩm chi tiết
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		String chitiet = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Sanpham spct = gs.fromJson(chitiet, Sanpham.class);
		// add hình ảnh vào
		List<Hinhanh> listha = TienIch.selectByIdSpHinhAnh(spct.getId());
		spct.setListHinhAnh(listha);
		model.addAttribute("spct", spct);
		List<NhanHieu> listnh = TienIch.ListNhanHieu();
		model.addAttribute("list", listnh);
		List<LoaiSanPham> list = TienIch.ListLoaiSanPham();
		model.addAttribute("lsp", list);
		return "sanpham/update";
	}

	// update thành công
	@PostMapping(value = "/update-success")
	public String updateSuccess(@ModelAttribute(value = "spct") @Valid Sanpham sanpham, BindingResult result,
			Model model, HttpServletRequest request, @RequestParam(value = "uploadFile") MultipartFile[] mf)
			throws IOException {
		// Add file hình ảnh vào
		List<Hinhanh> addHinhAnh = TienIch.selectByIdSpHinhAnh(sanpham.getId());
		sanpham.setListHinhAnh(addHinhAnh);
		if (result.hasErrors()) {
			// nạp thêm lits nhãn hiệu và list loai san pham
			List<NhanHieu> listnh = TienIch.ListNhanHieu();
			model.addAttribute("list", listnh);
			List<LoaiSanPham> list = TienIch.ListLoaiSanPham();
			model.addAttribute("lsp", list);
			model.addAttribute("spct", sanpham);
			return "sanpham/update";
		}
		//
		List<Hinhanh> listha = new ArrayList<Hinhanh>();
		String URL = "http://localhost:8080/Fashion-Shop-Api/rest/San-pham/update-san-pham";
		Client client = ClientBuilder.newClient();
		client.register(MultiPartFeature.class);
		WebTarget target2 = client.target(URL);
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		//////////////////////
		Date date = new Date();
		NhanHieu nh = new NhanHieu();
		nh.setId(sanpham.getIdnhanhieu());
		LoaiSanPham lsp = new LoaiSanPham();
		lsp.setId(sanpham.getIdtheloai());
		////////////////////
		for (MultipartFile mok : mf) {
			if (mok.getSize() == 0) {
				Sanpham sanphamok = new Sanpham(sanpham.getId(), sanpham.getName(), sanpham.getDescripe(),
						sanpham.getInformation(), sanpham.getPrice_import(), sanpham.getPrice_old(),
						sanpham.getPrice_new(), sanpham.getSp_view(), date, sanpham.isStatus(), nh, lsp,
						sanpham.getListHinhAnh());
				String data = gs.toJson(sanphamok);
				Response response = target2.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
				String trave = response.readEntity(String.class);
				ThongBao tb = gs.fromJson(trave, ThongBao.class);
				if (tb.getMacode() == 1) {
					return "redirect:/ql-san-pham";
				}
			} else {
				String tenanh = mok.getOriginalFilename();
				Hinhanh hinhanh = new Hinhanh(tenanh, sanpham);
				listha.add(hinhanh);
			}
		}
		try {
			List<Hinhanh> hinhanhtim = TienIch.selectByIdSpHinhAnh(sanpham.getId());
			ArrayList<Integer> arr = new ArrayList<Integer>(4);
			for (Hinhanh timhinh : hinhanhtim) {
				arr.add(timhinh.getId());
			}
			listha.get(0).setId(arr.get(0));
			listha.get(1).setId(arr.get(1));
			listha.get(2).setId(arr.get(2));
			listha.get(3).setId(arr.get(3));

			for (MultipartFile multi : mf) {
				for (Hinhanh lmanh : listha) {
					String ddgoc = request.getServletContext().getRealPath("/public/img");
					String mahinhanh = "http://localhost:8080/Fashion-Shop-Api/rest/Hinhanh/update";
					WebTarget targetha = client.target(mahinhanh);
					String dlhinhanh = gs.toJson(lmanh);
					File file = new File(ddgoc + File.separator + lmanh.getName());
					System.out.println(file);
					System.out.println("Đường dẫn api");
					if (lmanh.getName().equals(multi.getOriginalFilename())) {
						byte luu[] = multi.getBytes();
						Path path = file.toPath();
						Files.write(path, luu, StandardOpenOption.CREATE_NEW);
						// Đọc dữ liệu đã
						FormDataMultiPart fdm = new FormDataMultiPart();
						InputStream is = multi.getInputStream();
						fdm.field("mf", is, new MediaType());
						fdm.field("dulieu", dlhinhanh);
						// Vì là ko có id hình ảnh đúng ko
						Response response2 = targetha.request().post(Entity.entity(fdm, MediaType.MULTIPART_FORM_DATA));
						String traveha = response2.readEntity(String.class);
						ThongBao tbha = gs.fromJson(traveha, ThongBao.class);
						if (tbha.getMacode() == 0) {
							model.addAttribute("spok", sanpham);
							List<NhanHieu> listnh = TienIch.ListNhanHieu();
							model.addAttribute("list", listnh);
							List<LoaiSanPham> list = TienIch.ListLoaiSanPham();
							model.addAttribute("lsp", list);
							model.addAttribute("tb", tbha);
							return "sanpham/update";
						}
					}
				}
			}

			// Sau khi thêm xong thì sẽ thay đổi cả tên sản phẩm
			Sanpham sanphamok = new Sanpham(sanpham.getId(), sanpham.getName(), sanpham.getDescripe(),
					sanpham.getInformation(), sanpham.getPrice_import(), sanpham.getPrice_old(), sanpham.getPrice_new(),
					sanpham.getSp_view(), date, sanpham.isStatus(), nh, lsp, listha);
			String data = gs.toJson(sanphamok);
			Response response = target2.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
			String trave = response.readEntity(String.class);
			ThongBao tb = gs.fromJson(trave, ThongBao.class);
			if (tb.getMacode() == 0) {
				model.addAttribute("spok", sanpham);
				List<NhanHieu> listnh = TienIch.ListNhanHieu();
				model.addAttribute("list", listnh);
				List<LoaiSanPham> list = TienIch.ListLoaiSanPham();
				model.addAttribute("lsp", list);
				model.addAttribute("tb", tb);
				return "sanpham/update";
			}
		} catch (Exception e) {
			model.addAttribute("spok", sanpham);
			List<NhanHieu> listnh = TienIch.ListNhanHieu();
			model.addAttribute("list", listnh);
			List<LoaiSanPham> list = TienIch.ListLoaiSanPham();
			model.addAttribute("lsp", list);
			model.addAttribute("loinl", "Xảy ra lỗi file hình ảnh đã được lưu!");
			return "sanpham/update";
		}
		return "redirect:/ql-san-pham";
	}
}
