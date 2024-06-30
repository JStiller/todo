import {Component, Input} from '@angular/core';
import {MatListModule} from '@angular/material/list';
import { TodoItem } from '../item';
import type { Todo } from '../type';

/**
 * @title List with selection
 */
@Component({
  selector: 'todo-list',
  templateUrl: 'todo-list.html',
  standalone: true,
  imports: [MatListModule, TodoItem],
})
export class TodoList {
  @Input() todos: Todo[] = [];
}
