<h2>Client Info</h2>
<p>${clientName}</p>

<h2>Resource Owner</h2>
<p>${userName}</p>

<h2>Consent requested</h2>
<p>${scope}</p>

<form action="/authorize?${rc.queryString}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Allow</button>
</form>