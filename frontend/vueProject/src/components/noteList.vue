<template>
    <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
        <input
          type="text"
          class="form-control"
          placeholder="Search by title"
          v-model="searchTitle"
        />
        <div class="input-group-append">
          <button
            class="btn btn-outline-secondary"
            type="button"
            @click="page = 1; retrieveNotes();"
          >
            Search
          </button>
        </div>
      </div>
    </div>

    <div class="col-md-12">
      <div class="mb-3">
        Items per Page:
        <select v-model="pageSize" @change="handlePageSizeChange($event)">
          <option v-for="size in pageSizes" :key="size" :value="size">
            {{ size }}
          </option>
        </select>
      </div>

      <b-pagination
        v-model="page"
        :total-rows="count"
        :per-page="pageSize"
        prev-text="Prev"
        next-text="Next"
        @change="handlePageChange"
      ></b-pagination>
    </div>
      <div class="col-md-6">
        <h4>Notes List</h4>
        <ul class="list-group" id="notes-list">
          <li class="list-group-item"
            :class="{ active: index == currentIndex }"
            v-for="(note, index) in notes"
            :key="index"
            @click="setActiveNote(note, index)"
          >
            {{ note.note.title }}
          </li>
        </ul>
      </div>
      <div class="col-md-6">
        <div v-if="currentNote">
          <h4>Note</h4>
          <div>
            <label><strong>Title:</strong></label> {{ currentNote.note.title }}
          </div>
          <div>
            <label><strong>Content:</strong></label> {{ currentNote.note.content }}
          </div>
          <div>
            <label><strong>Label:</strong></label> {{ currentNote.label.name }}
          </div>
  
          <router-link :to="'/note/' + currentNote.note.id" class="badge badge-warning">Edit</router-link>
        </div>
        <div v-else>
          <br />
          <p>Please click on a Note...</p>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import NoteDataService from "../services/NoteDataService";
  
  export default {
    name: "notes-list",
    data() {
      return {
        notes: [],
        currentNote: null,
        currentIndex: -1,
        searchTitle: "",

        page: 1,
        count: 0,
        pageSize: 3,

        pageSizes:[3,6,9],
      };
    },
    methods: {
        getRequestParams(searchTitle, page, pageSize) {
            let params = {};

            if(searchTitle) {
                params["searchTitle"] = searchTitle;
            }

            if (page) {
                params["page"] = page - 1; 
            }

            if (pageSize) {
                params["size"] = pageSize;
            }

            return params;
        },

      retrieveNotes() {
        const params =this.getRequestParams(
            this.searchTitle,
            this.page,
            this.pageSize
        );

        NoteDataService.getAll(params)
          .then((response) => {
            const {content, totalItems } = response.data;
            this.notes = content;
            this.count = totalItems;

            console.log(response.data);
          })
          .catch((e) => {
            console.log(e);
          });
      },

      handlePageChange(value) {
        this.page = value;
        this.retrieveNotes();
      },

      handlePageSizeChange(event) {
        this.pageSize = event.target.value;
        this.page = 1;
        this.retrieveNotes();
      },
  
      refreshList() {
        this.retrieveNotes();
        this.currentNote = null;
        this.currentIndex = -1;
      },
  
      setActiveNote(note, index) {
        this.currentNote = note;
        this.currentIndex = note ? index : -1;
      },
      
      searchTitle() {
        NoteDataService.findByTitle(this.searchTitle)
          .then(response => {
            this.notes = response.data;
            this.setActiveNote(null);
            this.setActiveLabel(null);
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      }
    },
    mounted() {
      this.retrieveNotes();
    }
  };
  </script>
  
  <style>
  .list {
    text-align: left;
    max-width: 750px;
    margin: auto;
  }
  </style>
  