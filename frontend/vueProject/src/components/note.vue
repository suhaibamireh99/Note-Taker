<template>
    <div v-if="currentNote" class="edit-form">
      <h4>Note</h4>
      <form>
        <div class="form-group">
          <label for="title">Title</label>
          <input type="text" class="form-control" id="title"
            v-model="currentNote.title"
            maxlength="32"
            required
          />
        </div>
        <div class="form-group">
          <label for="content">Content</label>
          <textarea 
           class="form-control"
            id="content"
            required
            maxlength="300"
            v-model="currentNote.content"
            name="content"
            rows="4"
          />
        </div>
  
        <div class="form-group">
          <label><strong>LabelName:</strong></label>
          <input type="text" class="form-control" id="label"
          v-model="currentNote.labelName"
          maxlength="32"
          required
          />
        </div>
      </form>
  
  
      <button class="badge badge-danger mr-2"
        @click="deleteNote"
      >
        Delete
      </button>
  
      <button type="submit" class="badge badge-success"
        @click="updateNote"
      >
        Update
      </button>
      <p>{{ message }}</p>
    </div>
  
    <div v-else>
      <br />
      <p>Please click on a Note...</p>
    </div>
  </template>
  
  <script>
  import NoteDataService from "../services/NoteDataService";
  
  export default {
    name: "note",
    data() {
      return {
        currentNote: null,
        message: ''
      };
    },
    methods: {
      getNote(id) {
        NoteDataService.get(id)
          .then(response => {
            this.currentNote = response.data;
            console.log(response.data);
            console.log("heelooo")
          })
          .catch(e => {
            console.log(e);
          });
      },
  
      updateNote() {
        NoteDataService.create(this.currentNote)
          .then(response => {
            console.log(response.data);
            this.message = 'The note was updated successfully!';
          })
          .catch(e => {
            console.log(e);
          });
      },
  
      deleteNote() {
        NoteDataService.delete(this.currentNote.id)
          .then(response => {
            console.log(response.data);
            this.$router.push("/home");
          })
          .catch(e => {
            console.log(e);
          });
      }
    },
    mounted() {
      this.message = '';
      this.getNote(this.$route.params.id);
    }
  };
  </script>
  
  <style>
  .edit-form {
    max-width: 300px;
    margin: auto;
  }
  </style>
  