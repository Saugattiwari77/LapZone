<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <title>User Profile Form</title>

   <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/admin-form.css" />
  </head>
  <body>
    <body>
      <div class="formdiv">
        <form class="form">
          <h1>Add Product</h1>
          <label for="name">Product Name:</label>
          <input type="text" id="name" name="name" />

          <label for="description">Description:</label>
          <textarea id="description" name="description"></textarea>

          <label for="price">Price:</label>
          <input type="number" id="price" name="price" />

          <label for="image">Upload Image:</label>
          <input type="file" id="image" name="image" accept="image/*" />

          <button type="submit">Submit</button>
        </form>
      </div>
    </body>
  </body>
</html>

</body>
</html>