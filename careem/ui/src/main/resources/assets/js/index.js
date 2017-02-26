/**
 * Created by rishabh.sood on 26/02/17.
 */
function getData() {
    var data = {};
    data.userId = $('#user').val();
    data.startLocation = $('#startpincode').val();
    data.endLocation = $('#endpincode').val();
    data.type = $('#ctype').find(":selected").text();
    $.ajax({
        url: "/api/consignment/addConsignment",
        method: "POST",
        async: false,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (data) {
            $('#table').append('<tr><td>Promised Date</td><td>'+data.promisedDate+'</td></tr><tr><td>Cost</td><td>'+data.cost+'</td></tr>');
        },
        error: function (exception) {
            modal.error("Error", exception.responseText);
        },
        complete: $.noop
    });
    $('#result').show();
}

function register() {

}
