import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MatListModule } from '@angular/material/list';
import { TodoItem } from '../item';
import type { Todo } from '../type';

@Component({
  selector: 'todo-list',
  templateUrl: 'todo-list.html',
  standalone: true,
  imports: [MatListModule, TodoItem],
})
export class TodoList {
  @Input() todos: Todo[] = [];
  @Output() changeStatusEvent = new EventEmitter<Todo>();

  changeStatus(todo: Todo) {
    this.changeStatusEvent.emit(todo);
  }
}
