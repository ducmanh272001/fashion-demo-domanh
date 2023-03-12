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
 

$('.x-zoom, .xzoom-smale').xzoom({
    zoomWidth: 400,
    tint: '#333',
    Xoffset: 20
})