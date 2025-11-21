import { Component } from '@angular/core';
import { FeedAdd } from './feed-add/feed-add';
import { FeedList } from './feed-list/feed-list';

@Component({
	selector: 'app-feeds',
	imports: [FeedAdd, FeedList],
	templateUrl: './feeds.html',
	styleUrl: './feeds.css',
})
export class Feeds {

}
