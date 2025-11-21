import { EventEmitter, Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Feed } from './feed';

const restUrl = 'api/v1/feed'

@Injectable({
	providedIn: 'root',
})

export class FeedsService {
	onFeedAdded = new EventEmitter<Feed>();
	
	constructor(private http: HttpClient) { }

	getAll(): Observable<Feed[]> {
		return this.http.get<Feed[]>(restUrl);
	}
	
	create(data: any): Observable<any> {
		return this.http.post(restUrl, data);
	}
	
	delete(id: number): Observable<any> {
		return this.http.delete(`${restUrl}/${id}`)
	}
	
	update(feed: Feed): Observable<Feed>{
		return this.http.put<Feed>(`${restUrl}/${feed.id}`, feed);
	}
}
