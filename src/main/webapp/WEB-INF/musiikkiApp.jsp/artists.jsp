<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<style>
table, th, td {
	border: 1px solid black;
}
</style>

<script src="/scripts/app.js"></script>

<title>Music List</title>

</head>
<body>

	<h1>Music List</h1>

	<form method="post">
		<input type="hidden" name="action" value="save"> <input
			name="artistName" type="text" required
			placeholder="add Artist here..." autofocus /> <input type="submit"
			value="Add to list" />
	</form>

	<form method="post">
		<input type="hidden" name="action" value="search"> <input
			name="searchWithArtistName" type="text" required
			placeholder="search Artist here..." autofocus /> <input
			type="submit" value="Search to list" />
	</form>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${ Artists }" var="Artist">
			<tr>
				<td>${ Artist.getId() }</td>
				<td><a href="/albums?ArtistId=${ Artist.getId() }">${ Artist.getArtist() }</a></td>
			</tr>

		</c:forEach>

	</table>
</body>

</html>