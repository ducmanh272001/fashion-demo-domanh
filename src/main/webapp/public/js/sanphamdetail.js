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
 
 
 
 $(document).ready(function(){
    $('.btn-buttonone:first-child button').click(function(ev){
        ev.preventDefault()
        var prev = $(this).closest('.product-dem').find('input').val();
        
        if(prev == 0) {
            $(this).closest('.product-dem').find('input').val('0');
        }else{
            var preval = prev - 1;
            $(this).closest('.product-dem').find('input').val(preval);
        }
    })

    $('.btn-buttonone:last-child button').click(function(ev){
        ev.preventDefault()
        var next = $(this).closest('.product-dem').find('input').val();
        
        if(next == 100) {
            $(this).closest('.product-dem').find('input').val('100');
        }else{
            var nextval = ++next;
            $(this).closest('.product-dem').find('input').val(nextval);
        }
    })
})





$('#manhca').owlCarousel({
    autoplay: true,
    autoplayTimeout: 3000,
    loop: true,
    autoplayHoverPause: true,
    nav: true,
    responsive:{
        0:{
            items:1,
            dots:false
        },
        600:{
            items:2,
            dots:false
        },
        768:{
            items:3,
            dots:false 
        },
        1000:{
            items:4,
            dots:false
        }
    }
})



 $(window).scroll(function(){
     var dem = $(this).scrollTop();
     if(dem >= 1500){
       $('.back-top a').css({
         right:10,
         bottom:10
       });
     }else{
         $('.back-top a').css({
         right:-1000,
         bottom:10
       });
     }
 })
 $('.back-top a').click(function(ev){
    ev.preventDefault()
    $('html, body').animate({
        scrollTop: 0
    },1000)
 })


$('.x-zoom, .xzoom-smale').xzoom({
    zoomWidth: 400,
    tint: '#333',
    Xoffset: 20
})

new WOW().init();