<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<style>
table, th, td {
	border: 1px solid black;
}
</style>

<script src="/scripts/app.js"></script>

<title>Artist Albums</title>

</head>
<body>

	<h1>Albums of ${ ArtistName }</h1>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${ Albums }" var="Album">
			<tr>
				<td>${ Album.getAlbumId() }</td>
				<td>${ Album.getTitle() }</td>
			</tr>

		</c:forEach>

	</table>
</body>

</html>