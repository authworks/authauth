<h2>Client Info</h2>
<p>${clientName}</p>

<h2>Resource Owner</h2>
<p>${userName}</p>

<h2>Consent requested</h2>
<p>${scope}</p>

<form action="/authorize?${query}" method="post">
    <button type="submit">Allow</button>
</form>