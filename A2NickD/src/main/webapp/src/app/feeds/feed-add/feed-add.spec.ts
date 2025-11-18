import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedAdd } from './feed-add';

describe('FeedAdd', () => {
  let component: FeedAdd;
  let fixture: ComponentFixture<FeedAdd>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeedAdd]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeedAdd);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
