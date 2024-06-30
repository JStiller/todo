import {Component, EventEmitter, Input, Output} from '@angular/core';
import {MatListModule} from '@angular/material/list';
import {MatChipsModule} from '@angular/material/chips';
import { Todo } from '../type';

@Component({
  selector: 'todo-item',
  templateUrl: 'todo-item.html',
  standalone: true,
  imports: [MatListModule, MatChipsModule],
})
export class TodoItem {
  @Input() id = '';
  @Input() title = '';
  @Input() category = '';
  @Input() description = '';
  @Input() status = false;
  @Output() changeStatusEvent = new EventEmitter<Todo>();

  changeStatus() {
    this.changeStatusEvent.emit({
      id: this.id,
      title: this.title,
      category: this.category,
      description: this.description,
      status: !this.status
    })
  }
}
