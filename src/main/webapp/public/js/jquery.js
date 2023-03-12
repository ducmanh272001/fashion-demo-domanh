/**
 * 
 */
 
 

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

$('#cardxoay').owlCarousel({
    autoplay: true,
    autoplayTimeout: 3000,
    loop: true,
    autoplayHoverPause: true,
    nav: false,
    responsive:{
        0:{
            items:1,
            autoplay:false
        },
        600:{
            items:2,
            autoplay:false
        },
        768:{
            items:3,
            autoplay:false
        },
        1000:{
            items:5
        }
    }
})
$('#user-about').owlCarousel({
    autoplay: true,
    autoplayTimeout: 2000,
    loop: true,
    autoplayHoverPause: true,
    responsive:{
        0:{
            items:1
        },
        600:{
            items:2
        },
        768:{
            items:3 
        },
        1000:{
            items:4
        }
    }
})

$(window).on('load', function(){
    $('body').removeClass('loading')
    $('.nenmo').delay(900).fadeOut('fast')
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


$('.search-btn a').click(function(ev){
    ev.preventDefault()
     $('.nenmosearch').addClass('hiennenmosearch')
     $('body').addClass('overhidden')
})

$('.nenmosearch span').click(function(){
    $('.nenmosearch').removeClass('hiennenmosearch')
    $('body').removeClass('overhidden')
})


const countdown = () => {
    const countDate = new Date("July 30, 2023 00:00:00").getTime()
    const now = new Date().getTime();
    const gap = countDate - now

    const second = 1000;
    const minute = second * 60;
    const hour = minute * 60;
    const day = hour * 24

    const textDay = Math.floor(gap / day);
    const textHour = Math.floor((gap % day) / hour)
    const textMinutes = Math.floor((gap % hour) / minute);
    const textSecond = Math.floor((gap % minute) /second);

    document.getElementById("day").innerText =textDay
    document.getElementById("hours").innerText =textHour
    document.getElementById("minutes").innerText =textMinutes
    document.getElementById("seconds").innerText =textSecond
}
setInterval(countdown, 1000);

$('.open-quick').click(function(ev){
    ev.preventDefault()
    $('.modal-quick-view').addClass('hien-quickview')
    $('.modal-quickview-one').addClass('hien-quickview')
    $('body').addClass('overhidden')
})
$('#closequick').click(function(ev){
    ev.preventDefault()
    $('.modal-quick-view').removeClass('hien-quickview')
    $('.modal-quickview-one').removeClass('hien-quickview')
    $('body').removeClass('overhidden')
})

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




 