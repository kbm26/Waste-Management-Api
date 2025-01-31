INSERT INTO WasteCategories (Description, Name) VALUES
('Items made of plastic like bottles, bags, and containers', 'Plastic'),
('Glass materials like bottles and jars', 'Glass'),
('Paper products like newspapers, magazines, and cardboard', 'Paper'),
('Metal items such as cans and aluminum foil', 'Metal'),
('Biodegradable waste like food scraps and garden waste', 'Organic');

INSERT INTO DisposalGuidelines (WasteCategoryId, Description, Name) VALUES
(1, 'Place plastic waste in the blue recycling bin.', 'Plastic Disposal'),
(2, 'Glass should be placed in the green recycling bin.', 'Glass Disposal'),
(3, 'Paper waste should go into the yellow recycling bin.', 'General Paper Disposal'),
(3, 'Shredded paper should be placed in a sealed bag before recycling.', 'Shredded Paper Disposal'),
(3, 'Avoid recycling paper contaminated with food or grease.', 'Contaminated Paper Disposal'),
(4, 'Metal waste should be taken to a scrap metal collection point.', 'Metal Disposal - General'),
(4, 'Rusty metal items should be kept separate to avoid contamination.', 'Rusty Metal Disposal'),
(5, 'Organic waste can be composted at home or sent to a composting facility.', 'Organic Disposal');

INSERT INTO RecyclingTips (WasteCategoryId, Description, Name) VALUES
(1, 'Rinse plastic containers before recycling to avoid contamination.', 'Plastic Recycling Tip'),
(2, 'Remove lids from glass bottles before placing them in the recycling bin.', 'Glass Recycling Tip'),
(3, 'Flatten cardboard boxes to save space in recycling bins.', 'Paper Recycling Tip - Flattening'),
(3, 'Use both sides of paper before recycling to reduce waste.', 'Paper Recycling Tip - Reuse'),
(3, 'Keep magazines and glossy paper separate from standard paper recycling.', 'Paper Recycling Tip - Separation'),
(4, 'Separate aluminum cans from other metals for better recycling efficiency.', 'Metal Recycling Tip - Aluminum'),
(4, 'Crush cans before recycling to save space.', 'Metal Recycling Tip - Crushing'),
(5, 'Compost organic waste instead of sending it to landfills.', 'Organic Recycling Tip');
