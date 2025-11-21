import { Component } from '@angular/core';
import { FeedsService } from '../feeds-service';
import { Feed } from '../feed';
import { FormsModule } from '@angular/forms';

@Component({
	selector: 'app-feed-add',
	imports: [FormsModule],
	templateUrl: './feed-add.html',
	styleUrl: './feed-add.css',
})
export class FeedAdd {
	constructor(private fs: FeedsService) { }

	feed: Feed = {
		id: 0,
		author: '',
		title: '',
		details: '',
		//		time: '',
		//		date: ''
	};

	saveFeedPost(): void {
		const data = {
			author: this.feed.author,
			title: this.feed.title,
			details: this.feed.details,
			//			time: this.feed.time,
			//			date: this.feed.date
		};
		this.fs.create(data).subscribe(
			(data: Feed) => {
				this.fs.onFeedAdded.emit(data);

				this.feed.author = '';
				this.feed.title = '';
				this.feed.details = '';
				//				this.feed.time = '';
				//				this.feed.date = '';

			}

		);
	}
}
