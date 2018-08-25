<app>
  <div id="app" oncreate={ () => mounted() }>
    <div class="navbar">
      <div class="container">
        <a role="button" id="view" onclick={ () => showView() }>View</a> |
        <a role="button" id="edit" onclick={ () => showEdit() }>Edit</a> |
        <a href="/">Home</a>
      </div>
    </div>
  </div>

  <script>
    const state = {
      title: "New Notebook",
      sections: [],
      inEditMode: false
    }


  </script>


</app>