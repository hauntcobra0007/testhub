(function() {
    AJS.InlineDialog(jQuery('#mess'), 'myDialog', function(content, trigger, showPopup) { content.css({ padding: '20px' }).html(
'<h2>Error Message</h2>' +
'<p>Your name has not been entered.</p>');
showPopup();
return false;
});
}());