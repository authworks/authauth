
<form action="/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="text" name="username" placeholder="User name or Email">
    <input type="password" name="password" placeholder="Password">
    <button type="submit">Login</button>
</form>