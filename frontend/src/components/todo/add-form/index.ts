import { Component, EventEmitter, Output } from '@angular/core';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import axios from 'axios';
import type { Todo } from '../type';

@Component({
  selector: 'add-todo-form',
  standalone: true,
  imports: [MatSelectModule, MatInputModule, MatFormFieldModule, MatButtonModule, FormsModule],
  templateUrl: './add-todo-form.html',
  styleUrl: './add-todo-form.scss'
})
export class AddTodoForm {
  title = ''
  category = ''
  description = ''
  @Output() addTodoEvent = new EventEmitter<Todo>();

  async addTodo() {
    axios.request({
      url: "http://localhost:8080/api/v1/todo/",
      method: 'post',
      headers: {
        "Content-Type": "application/json"
      },
      withCredentials: false,
      data:{
        title: this.title,
        category: this.category,
        description: this.description
      }
    }).then((response) => {
      this.addTodoEvent.emit(response.data);
    })
  }
}
