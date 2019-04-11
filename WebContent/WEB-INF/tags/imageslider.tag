<%@ attribute name="interval" rtexprvalue="false" required="true"%>
<%@ tag body-content="empty" %>
<div class="container-fluid p-3 shadow">
	<div class="carousel slide" id="imgslider" data-ride="carousel"
		data-interval="${interval}">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="static/images/Backgrounds/1.jpg">
			</div>
			<div class="carousel-item">
				<img src="static/images/Backgrounds/2.jpg">
			</div>
			<div class="carousel-item">
				<img src="static/images/Backgrounds/3.jpg">
			</div>
		</div>
	</div>
</div>