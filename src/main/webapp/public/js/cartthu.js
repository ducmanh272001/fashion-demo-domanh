/**
 * 
 */
 
 
 
$('.barsindex ul li:first-child a').click(function(ev){
    ev.preventDefault()
    $(this).removeClass('hienrathanhbars')
    $(this).fadeOut('fade')
    $('.barsindex ul li:last-child a').addClass('hienrathanhbars')
    $('.maindm li').addClass('hienrathanhbars')
})
$('.barsindex ul li:last-child a').click(function(ev){
    ev.preventDefault()
    $(this).removeClass('hienrathanhbars')
    $('.barsindex ul li:first-child a').addClass('hienrathanhbars')
    $('.maindm li').removeClass('hienrathanhbars')
})
 
 
 $('.search-btn a').click(function(ev){
    ev.preventDefault()
     $('.nenmosearch').addClass('hiennenmosearch')
     $('body').addClass('overhidden')
})

$('.nenmosearch span').click(function(){
    $('.nenmosearch').removeClass('hiennenmosearch')
    $('body').removeClass('overhidden')
})


var dangnhap = document.getElementById('formcart')


function myFuntion(){
    document.getElementById('formcart').submit();
}