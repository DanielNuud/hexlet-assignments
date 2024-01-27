@import exercise.dto.posts.EditPostPage
@param EditPostPage page

@template.layout.page(content = @`
    <h2>Edit Post</h2>

    <form action="/posts/${page.getId()}/edit" method="post">
        <div class="mb-3">
            <label for="postName" class="form-label">Post Name</label>
            <input type="text" class="form-control" id="body" name="name" value="${page.getName()}">
        </div>

        <div class="mb-3">
            <label for="postBody" class="form-label">Post Body</label>
            <textarea class="form-control" id="body" name="body">${page.getBody()}</textarea>
        </div>

        <button type="submit" class="btn btn-primary">Save Changes</button>
    </form>
`)