import { Component, OnInit } from '@angular/core';
import { TodoList } from '../components/todo/list'
import { CardOverview } from '../components/card'
import { AddTodoForm } from '../components/todo/add-form';
import axios from 'axios';
import type { Todo } from '../components/todo/type';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [TodoList, CardOverview, AddTodoForm],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'todo-app';
  data: Todo[] = [];

  ngOnInit(): void {
    this.getTodos();
  }

  updateView(todo: Todo) {
      this.data.push(todo);
  }

  async getTodos() {
    await axios.request({
      url: "http://localhost:8080/api/v1/todo/",
      method: 'get',
      headers: {
        "Content-Type": "application/json"
      },
    }).then((response) => {
      this.data = response.data
    }).catch((error) => {
      throw new Error(error)
    })
  }
}
