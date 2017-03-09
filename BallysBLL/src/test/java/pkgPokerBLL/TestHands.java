package pkgPokerBLL;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class TestHands {

	@Test
	public void TestFullHouse() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Full House has no kickers.
		assertEquals(0,h.getHandScore().getKickers().size());
		
		
		
	}
	@Test
	public void TestRoyalFlush(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.KING,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));		
		h.EvaluateHand();
		
//		Hand better be a full house
			assertEquals(eHandStrength.RoyalFlush.getHandStrength(),
					h.getHandScore().getHandStrength().getHandStrength());
			
			//	HI hand better be 'Four' ??
			assertEquals(eRank.ACE.getiRankNbr(),
					h.getHandScore().getHiHand().getiRankNbr());

			assertEquals(eRank.TEN.getiRankNbr(),
					h.getHandScore().getLoHand().getiRankNbr());
			

			assertEquals(0,h.getHandScore().getKickers().size());
		
	}
	@Test
	public void TestStraightFlush()
	{
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.NINE,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.SPADES));		
		h.EvaluateHand();
		
//		Hand better be a full house
			assertEquals(eHandStrength.StraightFlush.getHandStrength(),
					h.getHandScore().getHandStrength().getHandStrength());
			
			//	HI hand better be 'Four' ??
			assertEquals(eRank.NINE.getiRankNbr(),
					h.getHandScore().getHiHand().getiRankNbr());

			assertEquals(eRank.FIVE.getiRankNbr(),
					h.getHandScore().getLoHand().getiRankNbr());
			

			assertEquals(0,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestFourOfAKind(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));		
		h.EvaluateHand();
		
//		Hand better be a full house
			assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
					h.getHandScore().getHandStrength().getHandStrength());
			
			//	HI hand better be 'ten'
			assertEquals(eRank.TEN.getiRankNbr(),
					h.getHandScore().getHiHand().getiRankNbr());
			

			assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestFourOfAKind2(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.SPADES));		
		h.EvaluateHand();
		
//		Hand better be a full house
			assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
					h.getHandScore().getHandStrength().getHandStrength());
			
			//	HI hand better be 'ten'
			assertEquals(eRank.TEN.getiRankNbr(),
					h.getHandScore().getHiHand().getiRankNbr());
			

			assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestAcesAndEights(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
		h.EvaluateHand();
		
			assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
					h.getHandScore().getHandStrength().getHandStrength());
		 	
			//	HI hand better be 'Ace'
			assertEquals(eRank.ACE.getiRankNbr(),
					h.getHandScore().getHiHand().getiRankNbr());

			assertEquals(eRank.EIGHT.getiRankNbr(),
					h.getHandScore().getLoHand().getiRankNbr());
			

			assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestAcesAndEights2(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.SPADES));		
		h.EvaluateHand();
		
			assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
					h.getHandScore().getHandStrength().getHandStrength());
		 	
			//	HI hand better be 'Ace'
			assertEquals(eRank.ACE.getiRankNbr(),
					h.getHandScore().getHiHand().getiRankNbr());

			assertEquals(eRank.EIGHT.getiRankNbr(),
					h.getHandScore().getLoHand().getiRankNbr());
			

			assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestFlush(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
		h.EvaluateHand();

			assertEquals(eHandStrength.Flush.getHandStrength(),
					h.getHandScore().getHandStrength().getHandStrength());
			
		
			assertEquals(eRank.QUEEN.getiRankNbr(),
					h.getHandScore().getHiHand().getiRankNbr());

			assertEquals(eRank.TWO.getiRankNbr(),
					h.getHandScore().getLoHand().getiRankNbr());
			

			assertEquals(0,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestStraight(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.NINE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.CLUBS));		
		h.EvaluateHand();

			assertEquals(eHandStrength.Straight.getHandStrength(),
					h.getHandScore().getHandStrength().getHandStrength());
			
		
			assertEquals(eRank.TEN.getiRankNbr(),
					h.getHandScore().getHiHand().getiRankNbr());

			assertEquals(eRank.SIX.getiRankNbr(),
					h.getHandScore().getLoHand().getiRankNbr());
			

			assertEquals(0,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestThreeOfAKind(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		

		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		

		
		
		assertEquals(2,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestThreeOfAKind2(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		

		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		

		
		
		assertEquals(2,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestThreeOfAKind3(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		

		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		
		assertEquals(2,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestTwoPair(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.SPADES));		
		h.EvaluateHand();
		

		assertEquals(eHandStrength.TwoPair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		

		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		

		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		

		assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestTwoPair2(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		

		assertEquals(eHandStrength.TwoPair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		

		assertEquals(eRank.FIVE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		

		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		

		assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestTwoPair3(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.SPADES));		
		h.EvaluateHand();
		

		assertEquals(eHandStrength.TwoPair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		

		assertEquals(eRank.KING.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		

		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		

		assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestOnePair(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.SPADES));		
		h.EvaluateHand();
		
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		assertEquals(3,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestHighCard(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));		
		h.EvaluateHand();
		

		assertEquals(eHandStrength.HighCard.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		

		assertEquals(eRank.ACE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		

		assertEquals(eRank.TWO.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		

		assertEquals(4,h.getHandScore().getKickers().size());
	}

}
