/**
 * 
 */
 


$(window).on('load', function(){
    $('body').removeClass('loading')
    $('.nenmo').delay(500).fadeOut('fast')
})


$('.card-btn a').click(function(ev){
    ev.preventDefault()
    $('.cart-max').addClass('carthienra')
    $('body').addClass('overhidden')
})
$('.cart-small-content button').click(function(){
    $('.cart-max').removeClass('carthienra')
    $('body').removeClass('overhidden')
})

var dangky = document.getElementById('dangkyv')
var matok = document.getElementById('nhappassword');
var matok2 = document.getElementById('nhaplaipassword');
var tendn = document.getElementById('tendn');
var nhapemail = document.getElementById('nhapemail');

dangky.onsubmit = function(ev){
    ev.preventDefault()
    if(dangky.tendn.value == 0){
        alert('Xin vui lòng nhập tên đăng ký')
    }else if(dangky.nhapemail.value == 0){
        alert('Xin vui lòng nhập email của bạn')
    }else if(matok.value == 0){
        alert('Xin vui lòng đặt mật khẩu của bạn')
    }else if(matok2.value == 0){
        alert('Xin vui lòng nhập lại mật khẩu của ban')
    }else{
        document.getElementById('dangkyv').submit();
    }
}
dangky.tendn.onblur=function(){
    if(dangky.tendn.value == 0){
        dangky.tendn.style.borderBottom = "2px solid red"
    }else{
        dangky.tendn.style.borderBottom = "2px solid green"
    }
}
dangky.nhapemail.onblur=function(){
    if(dangky.nhapemail.value == 0){
        dangky.nhapemail.style.borderBottom = "2px solid red"
    }else{
        dangky.nhapemail.style.borderBottom = "2px solid green"
    }
}
matok.onblur=function(){
    if(matok.value == 0){
        matok.style.borderBottom = "2px solid red"
    }else{
        matok.style.borderBottom = "2px solid green"
    }
}
matok2.onblur=function(){
    if(matok2.value == 0){
        matok2.style.borderBottom = "2px solid red"
    }else{
        matok2.style.borderBottom = "2px solid green"
    }
}
$('.matdangky').click(function(){
    $(this).toggleClass('doimat')
    $(this).children('i').toggleClass('fa-face-grin-tongue-wink')
    if ($(this).hasClass('doimat')) {
        $('.matnhin').attr('type', 'text')
    } else {
       $('.matnhin').attr('type', 'password')
    }
})
$('.matdangky1').click(function(){
    $(this).toggleClass('doimat')
    $(this).children('i').toggleClass('fa-face-grin-tongue-wink')
    if ($(this).hasClass('doimat')) {
        $('.matnhin1').attr('type', 'text')
    } else {
       $('.matnhin1').attr('type', 'password')
    }
})

$('.nuttat').click(function(ev){
    ev.preventDefault()
    $('.hopthoaimodal').addClass('hienrahopthoai')
    $('.hopthoai').addClass('hienrahopthoai')
})
$('.hopthoai span').click(function(){
    $('.hopthoaimodal').removeClass('hienrahopthoai')
    $('.hopthoai').removeClass('hienrahopthoai')
})

