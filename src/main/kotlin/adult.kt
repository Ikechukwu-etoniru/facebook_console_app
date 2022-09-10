class Adult : User() {

     fun approveChildPost () {
         println("Enter ID od the post you want to approve")
         val postId = readln().lowercase()
         val approvedPost = childPostAwaitingApproval.firstOrNull{it.postId == postId}

         if (approvedPost ==null) {
             println("No post awaiting approval with the id $postId exists")
             approveChildPost()
         }else {
             postList.add(approvedPost)
             println("This post with id $postId has been approved")
             openAdultAccount(user = userDb.first{it.userName == loggedInUserName})
         }

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
        openAdultAccount(user = userDb.first{it.userName == loggedInUserName})
    }

    override fun editPost() {
        println("Enter post id")
        val postId = readln().lowercase()
        println("Enter new content")
        val updatedContent = readln().lowercase()
        val postToEdit = postList.firstOrNull{it.id == postId}
        if (postToEdit == null) {
            println("No post exists with the id $postId")
            editPost()
        }else {
            postToEdit.postContent = updatedContent
            println("Post has been edited")
            openAdultAccount(user = userDb.first{it.userName == loggedInUserName})
        }
    }
}