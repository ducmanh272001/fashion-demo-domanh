/**
 * 
 */
 
 $('.oknhan').click(function(ev){
    ev.preventDefault()
    $('.thanhtrai').removeClass('dieuhuongan')
})


 $('.dongclose').click(function(ev){
    ev.preventDefault()
    $('.thanhtrai').addClass('dieuhuongan')
})