

class Admin : User() {
    fun flagPost () {
        println("Enter post id")
        val postId = readln().lowercase()
        println("This post with id $postId will be flagged")
        openAdminAccount(user = userDb.first{it.userName == loggedInUserName})
    }

    fun banAccount () {
        println("Enter account username")
        val acctUserName = readln().lowercase()


        println("This account with name $acctUserName will be banned")
        openAdminAccount(user = userDb.first{it.userName == loggedInUserName})
    }

    override fun createPost() {
        println("Enter post id")
        val postId = readln().lowercase()
        println("Enter post title")
        val postTitle = readln().lowercase()
        println("Enter post content")
        val postContent = readln().lowercase()

        val thisUserPost = UserPost(id = postId, title = postTitle, content = postContent)
        postList.add(thisUserPost)
        println("Post created successfully")
        openAdminAccount(user = userDb.first{it.userName == loggedInUserName})
    }

    override fun editPost() {
        println("Enter post id")
        val postId = readln().lowercase()
        println("Enter new content")
        val updatedContent = readln().lowercase()
        val postToEdit = postList.firstOrNull {it.id == postId}

        if (postToEdit == null) {
            println("No post exists with the id $postId")
            editPost()
        }else {
            postToEdit.postContent = updatedContent
            println("Post has been edited")
            openAdminAccount(user = userDb.first{it.userName == loggedInUserName})
        }

    }
}