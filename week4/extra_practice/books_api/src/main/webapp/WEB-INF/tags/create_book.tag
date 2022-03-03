<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
        <div class="row">
            <div class="col col-sm-12">
                <h1 class="">New Book</h1>
                    <div class="card">
                        <form method="post" action="/books/" class="card-body">
                            <div class="row mb-3">
                                <label for="book_title" class="form-label">Title:</label>
                                <input type="text" class="form-control" name="book_title">
                            </div>
                            <div class="row mb-3">
                                <label for="book_description" class="form-label">Description:</label>
                                <textarea rows="3" class="form-control" name="book_description"></textarea>
                            </div>
                            <div class="row mb-3">
                                <label for="book_language" class="form-label">Language:</label>
                                <input type="text" class="form-control" name="book_language">
                            </div>
                            <div class="row mb-3">
                                <label for="book_num_of_pages" class="form-label">Number of pages:</label>
                                <input type="number" min="100" class="form-control" name="book_num_of_pages">
                            </div>
                            <div class="row justify-content-end">
                                <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>