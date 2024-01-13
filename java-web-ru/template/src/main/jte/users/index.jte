@import exercise.dto.users.UsersPage
@param UsersPage page


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UsersPage</title>
</head>
<body>
<header>
    <h1>Users</h1>
    @if(page.getUsers().isEmpty())
        <h1>Empty list</h1>
    @else
        @for(var user : page.getUsers())
            <div>
                <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
                <h3>${user.getEmail()}</h3>
            </div>
        @endfor

    @endif
</header>


</body>
</html>
