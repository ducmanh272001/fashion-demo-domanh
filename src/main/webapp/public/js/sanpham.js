/**
 * 
 */
 
 
 
 var sanphamday = document.getElementById('sanphamsubmit')

sanphamday.onsubmit = function(ev){
  var $fileUpload = $("input[type='file']");
  if (parseInt($fileUpload.get(0).files.length)>=1){
      function submitDetailsForm() {
       $("#sanphamsubmit").submit();
    }
  }else{
     alert("Tối thiểu 1 hình ảnh");
     ev.preventDefault();
     return  false;
  }
}