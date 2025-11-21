import { Component, ChangeDetectorRef, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Feed } from '../feed';
import { FeedsService } from '../feeds-service';
import { FormsModule } from '@angular/forms';

@Component({
	selector: 'app-feed-list',
	imports: [FormsModule, CommonModule],
	templateUrl: './feed-list.html',
	styleUrl: './feed-list.css',
})
export class FeedList implements OnInit {

	feeds: Feed[] = [];

	constructor(private fs: FeedsService, private cdr: ChangeDetectorRef) { }

	ngOnInit(): void {
		this.getFeeds();
		this.fs.onFeedAdded.subscribe(
			(data: Feed) => this.feeds.push(data)
		);
	}

	getFeeds(): void {
		this.fs.getAll().subscribe({
			next: (data) => {
				this.feeds = data;
			}
		});
	}
	
	deleteFeed(id: number | undefined): void{
		if (!id) return;
		
		this.fs.delete(id).subscribe({
			next: () => {
				this.feeds = this.feeds.filter(f => f.id !== id);
				console.log(`Successful post deletion: ${id}`);
				
				this.cdr.markForCheck();
				this.cdr.detectChanges()
				//window.location.reload();
				},
				error: (err) => {
					console.error('Failed to delete post:', err);
				}
		});
	}
}
