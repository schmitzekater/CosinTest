
function showSpinner(visible){
    /**
     * Anzeigen des "Spinners" während der AJAX-Call läuft
     */
    if(visible) $('#spinner').show();
    else $('#spinner').hide();
}
function refresh(){
    /**
     * Ersetzt den Vorgabewert in den Eingabefeldern.
     * Wenn ein Eingabefeld selektiert wird, wird der Vorgabewert gelöscht.
     * Wird kein Wert eingetragen, wird der Vorgabewert wieder hinterlegt.
     */
    jQuery("input").each(function() {
    // clear form field on focus and restore if empty
        var default_value = this.value;
        jQuery(this).focus(function(){
            if(this.value == default_value) {this.value = '';}
        });
        jQuery(this).blur(function(){
            if(this.value == '') {this.value = default_value;}
        });
    });
}