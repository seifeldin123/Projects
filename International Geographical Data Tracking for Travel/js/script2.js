$(document).ready(function() {
	$('#uploadBtn').on('click', function() {
		var file_data = $('#imageFile').prop('files')[0];
		var form_data = new FormData();
		form_data.append('file', file_data);

		$.ajax({
			url: 'upload.php',
			type: 'POST',
			data: form_data,
			contentType: false,
			cache: false,
			processData: false,
			success: function(response) {
				if (response == 1) {
					$('#uploadModal').modal('hide');
					location.reload(); // reload the page},
					error: function(error) {
        $('#uploadError').text('Error uploading file. Please try again.');
}
});
});
});





