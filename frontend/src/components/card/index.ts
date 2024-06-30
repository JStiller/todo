import {ChangeDetectionStrategy, Component} from '@angular/core';
import {MatCardModule} from '@angular/material/card';

/**
 * @title Basic cards
 */
@Component({
  selector: 'card-overview',
  templateUrl: 'card-overview.html',
  styleUrl: 'card-overview.scss',
  standalone: true,
  imports: [MatCardModule],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CardOverview {
  appearance = 'raised'
}
