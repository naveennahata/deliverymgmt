/**
 * Created by rishabh.sood on 26/02/17.
 */
function getData() {
    var data = {};
    data.userId = $('#user').text();
    data.startLocation = $('#startpincode').text();
    data.endLocation = $('#endpincode').text();
    data.type = $('#type').find(":selected").text();
    $.ajax({
        url: "/api/consignment/addConsignment",
        method: "POST",
        async: false,
        data: data,
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
