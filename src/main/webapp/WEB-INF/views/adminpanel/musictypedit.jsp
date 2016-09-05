<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-12">
		<form:form method="POST" modelAttribute="categoriForm"
			action="/admin/katagoriler/${categoriForm.id}/duzenle">
			<div class="form-group has-success">
				<label class="control-label" for="success">Katagori Adı</label>
				<form:input path="name" type="text" class="form-control"
					id="success" placeholder="Adı" />
			</div>
			<div class="form-group has-success">
				<label class="control-label" for="queue">Sırası:</label>
				<form:select path="queue" class="form-control" id="queue">
					<option ${categoriForm.queue == 1 ? "selected": "" }>1</option>
					<option ${categoriForm.queue == 2 ? "selected": "" }>2</option>
					<option ${categoriForm.queue == 3 ? "selected": "" }>3</option>
					<option ${categoriForm.queue == 4 ? "selected": "" }>4</option>
					<option ${categoriForm.queue == 5 ? "selected": "" }>5</option>
					<option ${categoriForm.queue == 6 ? "selected": "" }>6</option>
					<option ${categoriForm.queue == 7 ? "selected": "" }>7</option>
					<option ${categoriForm.queue == 8 ? "selected": "" }>8</option>
					<option ${categoriForm.queue == 9 ? "selected": "" }>9</option>
					<option ${categoriForm.queue == 10 ? "selected": "" }>10</option>
					<option ${categoriForm.queue == 11 ? "selected": "" }>11</option>
				</form:select>
			</div>
			<div class="form-group" style="float: right">
				<button type="submit" class="btn btn-success">Kaydet</button>
			</div>
		</form:form>

	</div>
	<!--  end  Context Classes  -->
</div>