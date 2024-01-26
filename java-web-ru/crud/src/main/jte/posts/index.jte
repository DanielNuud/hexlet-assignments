@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(content = @`
    @for(var post : page.getPosts())
        <ul>
            <li><a href="/posts/${post.getId()}">${post.getName()}</a></li>
            <p>${post.getBody()}</p>
        </ul>
    @endfor

    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item @if(page.getCurrentPage() == 1) disabled @endif">
                <a class="page-link" href="/posts?page=${page.getCurrentPage() - 1}" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            @for(var i = 1; i <= page.getPosts().size(); i++)
                <li class="page-item @if(page.getCurrentPage() == i) active @endif">
                    <a class="page-link" href="/posts?page=${i}">${i}</a>
                </li>
            @endfor
            <li class="page-item @if(page.getCurrentPage() == page.getPosts().size()) disabled @endif">
                <a class="page-link" href="/posts?page=${page.getCurrentPage() + 1}">Next</a>
            </li>
        </ul>
    </nav>
`)