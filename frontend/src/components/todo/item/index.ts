import {Component, Input} from '@angular/core';
import {MatListModule} from '@angular/material/list';
import {MatChipsModule} from '@angular/material/chips';

/**
 * @title List with selection
 */
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
}
