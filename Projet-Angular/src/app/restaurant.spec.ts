import { Restaurant } from './restaurant';

describe('Restaurant', () => {
  it('should create an instance', () => {
    expect(new Restaurant(nom,image,prix)).toBeTruthy();
  });
});
