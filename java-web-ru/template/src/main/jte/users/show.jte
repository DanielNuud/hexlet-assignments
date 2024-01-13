@import exercise.dto.users.UserPage
@param UserPage page

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UserPage</title>
</head>
<body>
    <h1>User №${page.getUser().getId()}</h1>
    <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
    <h3>${page.getUser().getEmail()}</h3>
</body>
</html>
