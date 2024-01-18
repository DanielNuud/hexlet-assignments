@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
    </form>

    <h1>Users</h1>
    @if(page.getUsers().isEmpty())
        <h1>Empty list</h1>
    @else
        @for(var user : page.getUsers())
            <ul>
                <li><h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
                    <p>${user.getEmail()} </p>
                </li>
            </ul>
        @endfor
    @endif
`)