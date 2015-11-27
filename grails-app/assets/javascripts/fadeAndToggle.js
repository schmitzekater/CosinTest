/**
 * Created by Alexander on 27.11.2015.
 */


function toggleErrorDetails() {
    $('.error-content').slideToggle('fast');
}
$('#topAlerts').delay(5000).fadeOut('slow');
$('.error-expand').click(function () {
    $('.error-content').slideToggle('fast');
})
$(document).ready(function () {
    window.setTimeout("toggleErrorDetails();", 5000);
})

