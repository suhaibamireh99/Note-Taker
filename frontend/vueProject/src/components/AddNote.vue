<template>
    <div class="submit-form">
        <h4>Add new Note</h4>
      <div v-if="!submitted">
        <div class="form-group">
          <label for="title">Title</label>
          <input
            type="text"
            class="form-control"
            id="title"
            required
            maxlength="32"
            v-model="note.title"
            name="title"
          />
        </div>
  
        <div class="form-group">
          <label for="content">Content</label>
          <textarea
            class="form-control"
            id="content"
            required
            maxlength="300"
            v-model="note.content"
            name="content"
            rows="4"
          />
        </div>

        <div class="form-group">
          <label for="content">Label Name</label>
          <input
            class="form-control"
            id="LabelNameInput"
            type="text"
            maxlength="32"
            v-model="note.labelName"
            name="contenLabelNameInputt"
          />
        </div>
  
        <button type="submit" @click="saveNote" class="btn btn-success">Submit</button>
      </div>
  
      <div v-else>
        <h4>You submitted successfully!</h4>
        <button class="btn btn-success" @click="newNote">Add</button>
      </div>
    </div>
  </template>
  
  <script>
  import NoteDataService from "../services/NoteDataService";
  export default {
    name: "add-note",
    data() {
      return {
        note: {
          title: null,
          content: null,
          labelName: null
        }
      };
    },
    methods: {
      saveNote() {
        var data = {
          title: this.note.title,
          content: this.note.content,
          labelName: this.note.labelName
        };
        NoteDataService.create(data)
          .then(response => {
            this.note.id = response.data.id;
            console.log(response.data);
            this.submitted = true;
          })
          .catch(e => {
            console.log(e);
          });
      },
      
      newNote() {
        this.note = {};
      },
      
      }
    }
  </script>
  
  <style>
  .submit-form {
    max-width: 300px;
    margin: auto;
  }
  </style>
  
  