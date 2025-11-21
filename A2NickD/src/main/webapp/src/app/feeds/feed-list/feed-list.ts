import { Component } from '@angular/core';
import { Feed } from '../feed';
import { FeedsService } from '../feeds-service';
import { FormsModule } from '@angular/forms';

@Component({
	selector: 'app-feed-list',
	imports: [FormsModule],
	templateUrl: './feed-list.html',
	styleUrl: './feed-list.css',
	standalone: true,
})
export class FeedList {

	feeds: Feed[] = [];
	editingId: number | null = null;

	constructor(private fs: FeedsService) { }

	ngOnInit(): void {
		this.getFeeds();
		this.fs.onFeedAdded.subscribe(
			(data: Feed) => this.feeds.unshift(data)	//used unshift instead of push because push adds the new item to the bottom of the list instead of the top.
		);
	}

	getFeeds(): void {
		this.fs.getAll().subscribe({
			next: (data) => {
				this.feeds = data;
			}
		});
	}

	deleteFeed(id: number | undefined): void {
		if (!id) return;

		this.fs.delete(id).subscribe({
			next: () => {
				this.getFeeds();
			}
		});
	}
	
	startEdit(id: number | undefined): void{
		if(id){
			this.editingId = id;
		}
	}
	
	cancelEdit(): void{
		this.editingId = null;
	}
	
	saveEdit(feed: Feed): void {
		this.fs.update(feed).subscribe({
			next: (updatedFeed) => {
				const index = this.feeds.findIndex(f => f.id === updatedFeed.id)
				if (index !== -1) {
					this.feeds[index] = updatedFeed;
				}
				this.editingId = null;
			}
		});
	}

}
