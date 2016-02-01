/**
 * Created by schmitza on 01.02.2016.
 */

function showSpinner(visible) {
    /**
     * Anzeigen des "Spinners" während der AJAX-Call läuft
     */
    if (visible) $('#spinner').show();
    else $('#spinner').hide();
}