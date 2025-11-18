import { Component } from '@angular/core';
import { Feed } from '../feed';
import { FeedsService } from '../feeds-service';

@Component({
  selector: 'app-feed-list',
  imports: [],
  templateUrl: './feed-list.html',
  styleUrl: './feed-list.css',
})
export class FeedList {
	feeds: Feed[]=[];
	
	constructor(private fs: FeedsService) { }
}
