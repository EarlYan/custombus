$(document).ready(function() {
	// InitCarousel();
 //    InitPropertyCarousel();
	InitOffCanvasNavigation();
	// InitChosen();
	// InitEzmark();
	// InitPriceSlider();
	// InitImageSlider();
	// InitAccordion();
	// InitTabs();
});

// function InitPropertyCarousel() {
//     $('.carousel.property .content li img').on({
//         click: function(e) {
//             var src = $(this).attr('src');
//             var img = $(this).closest('.carousel.property').find('.preview img');
//             img.attr('src', src);
//             $('.carousel.property .content li').each(function() {
//                 $(this).removeClass('active');
//             });
//             $(this).closest('li').addClass('active');
//         }
//     })
// }

// function InitTabs() {
// 	$('.tabs a').click(function (e) {
//   		e.preventDefault();
//   		$(this).tab('show');
// 	});
// }

// function InitImageSlider() {
// 	$('.iosSlider').iosSlider({
// 		desktopClickDrag: true,
// 		snapToChildren: true,
// 		infiniteSlider: true,
// 		navSlideSelector: '.slider .navigation li',
// 		onSlideComplete: function(args) {
// 			if(!args.slideChanged) return false;

// 			$(args.sliderObject).find('.slider-info').attr('style', '');

// 			$(args.currentSlideObject).find('.slider-info').animate({
// 				left: '15px',
// 				opacity: '.9'
// 			}, 'easeOutQuint');
// 		},
// 		onSliderLoaded: function(args) {
// 			$(args.sliderObject).find('.slider-info').attr('style', '');

// 			$(args.currentSlideObject).find('.slider-info').animate({
// 				left: '15px',
// 				opacity: '.9'
// 			}, 'easeOutQuint');
// 		},
// 		onSlideChange: function(args) {
// 			$('.slider .navigation li').removeClass('active');
// 			$('.slider .navigation li:eq(' + (args.currentSlideNumber - 1) + ')').addClass('active');
// 		},
// 		autoSlide: true,
// 		scrollbar: true,
// 		scrollbarContainer: '.sliderContainer .scrollbarContainer',
// 		scrollbarMargin: '0',
// 		scrollbarBorderRadius: '0',
// 		keyboardControls: true
// 	});
// }

// function InitAccordion() {
//     $('.accordion').on('show', function (e) {
//         $(e.target).prev('.accordion-heading').find('.accordion-toggle').addClass('active');
//     });

//     $('.accordion').on('hide', function (e) {
//         $(this).find('.accordion-toggle').not($(e.target)).removeClass('active');
//     });
// }

// function InitPriceSlider() {
//     jQuery('.price-value .from').text(100);
//     jQuery('.price-value .from').currency({ region: 'EUR', thousands: ' ', decimal: ',', decimals: 0 });

//     jQuery('.price-value .to').text(1000000);
//     jQuery('.price-value .to').currency({ region: 'EUR', thousands: ' ', decimal: ',', decimals: 0 });

//     $('.property-filter .price-slider').slider({
//         range: true,
//         min: 100,
//         max: 1000000,
//         values: [100, 1000000],
//         slide: function(event, ui) {
//             jQuery('.property-filter .price-from input').attr('value', ui.values[0]);
//             jQuery('.property-filter .price-to input').attr('value', ui.values[1]);

//             jQuery('.price-value .from').text(ui.values[0]);
//             jQuery('.price-value .from').currency({ region: 'EUR', thousands: ' ', decimal: ',', decimals: 0 });

//             jQuery('.price-value .to').text(ui.values[1]);
//             jQuery('.price-value .to').currency({ region: 'EUR', thousands: ' ', decimal: ',', decimals: 0 });
//         }
//     });
// }

// function InitEzmark() {
// 	$('input[type="checkbox"]').ezMark();
// 	$('input[type="radio"]').ezMark();
// }

// function InitChosen() {
// 	$('select').chosen({
// 		disable_search_threshold: 10
// 	});
// }

function InitOffCanvasNavigation() {
	$('#btn-nav').on({
		click: function() {
			$('body').toggleClass('nav-open');
		}
	})
}

// function InitCarousel() {
// 	$('#main .carousel .content ul').carouFredSel({
// 		scroll: {
// 			items: 1
// 		},
// 		auto: false,
// 		next: {
//     		button: '#main .carousel-next',
//     		key: 'right'
// 		},
// 		prev: {
//     		button: '#main .carousel-prev',
//     		key: 'left'
// 		}
// 	});

// 	$('.carousel-wrapper .content ul').carouFredSel({
// 		scroll: {
// 			items: 1
// 		},
// 		auto: false,
// 		next: {
//     		button: '.carousel-wrapper .carousel-next',
//     		key: 'right'
// 		},
// 		prev: {
//     		button: '.carousel-wrapper .carousel-prev',
//     		key: 'left'
// 		}
// 	});
// }