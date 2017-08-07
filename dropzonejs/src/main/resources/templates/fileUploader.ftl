
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" name="viewport"
	content="width=device-width, initial-scale=1">
<title>Springboot + Dropzone.js Example</title>

<link rel="stylesheet" type="text/css"
	href='/libs/bootstrap-3.1.1/css/bootstrap.min.css'>
<link rel="stylesheet" type="text/css"
	href='/libs/bootstrap-dialog/css/bootstrap-dialog.min.css'>
<link rel="stylesheet" type="text/css"
	href='/css/style.css'>

</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h3>Spring MVC + Dropzone.js Example</h3>
			</div>
			<div class="panel-body">
				<div>
					<form id="dropzone-form" class="dropzone"
						enctype="multipart/form-data">

						<div
							class="dz-default dz-message file-dropzone text-center well col-sm-12">

							<span class="glyphicon glyphicon-paperclip"></span> <span>
								To attach files, drag and drop here</span><br> <span>OR</span><br>
							<span>Just Click</span>
						</div>

						<!-- this is were the previews should be shown. -->
						<div class="dropzone-previews"></div>
					</form>
					<hr>
					<button id="upload-button" class="btn btn-primary">
						<span class="glyphicon glyphicon-upload"></span> Upload
					</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src='/libs/jquery/jquery-2.1.1.js'></script>
	<script type="text/javascript"
		src='/libs/bootstrap-3.1.1/js/bootstrap.js'></script>
	<script type="text/javascript"
		src='/libs/bootstrap-dialog/js/bootstrap-dialog.min.js'></script>
	<script type="text/javascript"
		src='/libs/dropzone.js'></script>
	<script type="text/javascript"
		src='/js/app.js'></script>
</body>
</html>