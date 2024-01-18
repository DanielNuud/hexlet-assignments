@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <ul>
        <li><h1>User ${page.getUser().getId()}</h1></li>
        <li><h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2></li>
        <li><h3>${page.getUser().getEmail()}</h3></li>
    </ul>
`)